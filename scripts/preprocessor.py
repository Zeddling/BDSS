import cv2
import glob
import logging
import numpy as np
import pandas as pd
from tqdm.cli import tqdm

log = logging.getLogger("preprocessor")
class preprocessor:
    def __init__(self, input_dir, output_dir):
        self.input_dir = input_dir
        self.output_dir = output_dir
    
    def gray_scale(self, img):
        return cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)

    def threshold(self, img):
        kernel = np.ones((3,10), np.uint8)
        blur = cv2.GaussianBlur(img, (5,5), 0)
        img_thresh = cv2.threshold(img, 0, 255, cv2.THRESH_BINARY+cv2.THRESH_OTSU)[1]
        img_dilate = cv2.dilate(img_thresh, kernel, iterations=1)
        img_erode = cv2.erode(img_dilate, kernel, iterations=1)
        return cv2.medianBlur(img_erode, 7) 

    def make_clearer(self, img):
        blur = cv2.GaussianBlur( img, (5,5), 0 )
        clahe = cv2.createCLAHE(clipLimit=5)
        clear_img = clahe.apply(img) + 30
        return cv2.cvtColor(clear_img, cv2.COLOR_GRAY2RGB)

    def mask_and_segment(self, img, original_image):
        cnt = sorted(cv2.findContours(img, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)[-2], key=cv2.contourArea)[-1]
        mask = np.zeros((600, 600), np.uint8)
        cv2.drawContours(mask, [cnt], -1, 255, -1)
        dst = cv2.bitwise_and(original_image, original_image, mask=mask)
        segmented_img = cv2.cvtColor(dst, cv2.COLOR_BGR2GRAY)
        return segmented_img	#	self.make_clearer(segmented_img)

    #   Save image
    def save_file( self, segmented, file ):
        pathlist = file.split("/")
        output = self.output_dir + "/" +pathlist[-1]
        cv2.imwrite( output, segmented )
    
    def process_images(self):
        for i, file in enumerate(glob.glob(self.input_dir+"/*.png")):
            img_file = cv2.imread(file)
            img = cv2.resize( img_file, (600,600), interpolation=cv2.INTER_AREA)
            gray = self.gray_scale(img)
            thresh = self.threshold(gray)
            segmented = self.mask_and_segment(thresh, img)
            self.save_file( segmented, file )
            print("File {} saved".format(i))
