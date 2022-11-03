# TODO

## Model tasks

**none for now**

## Controller flow

1. User loads an image and chooses a name to store each as
    1. Check if the image file exists
        * If the file does not exist, prompt user to retry command
        * If the file does exist, make a new file input stream
    2. Read the pixels of the file input stream, and creates image object for it
        * Read method will check if the image file is valid and is a supported filetype
        * Method will attempt to create an image object for each, catch errors and pass them to the
          controller, and prompt the user to retry command
        * Method will return an image object if the file is valid
    3. Check if the image name is already in the collection
        * If the image name is already in the collection, allow to continue, but remove the old item
          with the same key from the collection and replace it with the new image object
    4. Add the valid image object to the collection stack with the valid chosen name as the key
        * If the collection throws an error of some kind, catch and transmit to the user
2. Transform image commands
    * Start with the transformation's command, the loaded image to operate on, and the name of the
      new image to output to.

    1. Check if the transformation exists
    2. Check that the transformation's parameters exist (e.g. brighten amt, value, etc)
    3. Check if the source image is loaded, if not prompt user to retry command
    4. Check if the output image name is taken, if not prompt user to retry command
    5. Create a new image object given the original image object to apply transformations to
    6. If all parameters exist, create a new transformation object using the cloned image object
        * If the object is not constructed due to invalid arguments, prompt user to retry command
    7. Add the image to the image collection and notify user of success
3. List currently stored images command
    * If no images currently stored, say that
    * Else print a list of names in the collection object
4. List available transformations command
    * That way you don't have to include all transformations in the menu
5. Save a currently stored image by name command and output file
    * Check if the image name does exist, else say it does not exist
    * If the image exists in the co

## Notes

1. Don't need a view for this assignment at all except maybe to transmit messages to the user

## Tests to write

1. hahahahahahahahah fuck