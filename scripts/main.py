from preprocessor import preprocessor
import sys, getopt


def main(argv):
    input_dir = None
    output_dir = None
    
    try:
        opts, args = getopt.getopt(argv, "i:o:", ["input =", "output ="])
    except getopt.GetoptError:
        print("Error")

    for opt, arg in opts:
        if opt in ['-i', '--input']:
            input_dir = arg
        if opt in ['-o', '--output']:
            output_dir = arg

    pp = preprocessor(input_dir, output_dir)
    pp.process_images()

if __name__ == "__main__":
    main(sys.argv[1:])