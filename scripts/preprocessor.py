import cv2
import glob
import numpy as np
import pandas as pd
from tqdm.cli import tqdm

class preprocessor:
    def __init__(self, input_dir, output_dir):
        paths = glob.glob(input_dir+"/*.png")
        
        #   Load images from the paths and save them to a numpy array
        orig_list = []
        for img_path in paths:
            orig_img = cv2.imread(img_path) 
            orig_img = cv2.resize(orig_img, (277,277), interpolation=cv2.INTER_AREA)
            orig_list.append(orig_img)
        self.paths = paths
        self.original_images = np.array(orig_list)
        self.output_dir = output_dir
    
    def gray_scale(self):
        return [cv2.cvtColor(img, cv2.COLOR_RGB2GRAY) for img in tqdm(self.original_images)]

    def threshold(self, gray):
        thresh = []
        kernel = np.ones((3,10), np.uint8)
        for img in tqdm(gray):
            blur = cv2.GaussianBlur(img, (5,5), 0)
            img_thresh = cv2.threshold(img, 0, 255, cv2.THRESH_BINARY+cv2.THRESH_OTSU)[1]
            img_dilate = cv2.dilate(img_thresh, kernel, iterations=1)
            img_erode = cv2.erode(img_dilate, kernel, iterations=1)
            img_erode = cv2.medianBlur(img_erode, 7)
            thresh.append(img_erode)
        return thresh

    def make_clearer(self, img):
        blur = cv2.GaussianBlur( img, (5,5), 0 )
        clahe = cv2.createCLAHE(clipLimit=5)
        clear_img = clahe.apply(img) + 30
        return cv2.cvtColor(clear_img, cv2.COLOR_GRAY2RGB)

    def mask_and_segment(self, thresh):
        segmented = []
        for i, img in tqdm(enumerate(thresh)):
            cnt = sorted(cv2.findContours(img, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)[-2], key=cv2.contourArea)[-1]
            mask = np.zeros((277, 277), np.uint8)
            dst = cv2.bitwise_and(self.original_images[i], self.original_images[i], mask=mask)
            segmented_img = cv2.cvtColor(dst, cv2.COLOR_BGR2GRAY)
            segmented.append(self.make_clearer(segmented_img))
        return segmented

    #   Save image
    def save_file( self, segmented ):
        for i, file in tqdm(enumerate(segmented)):
            path = self.paths[i]
            filename = path.split("/")[-1]
            output = self.output_dir + "/" +filename
            cv2.imwrite( output, file )
    
    def process_images(self):
        gray = self.gray_scale()
        thresh = self.threshold(gray)
        segmented = self.mask_and_segment(thresh)
        self.save_file( segmented )