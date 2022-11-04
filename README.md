# CS3500 Assignment 4

## Overview

### This project represents an Image Processor that allows you to manipulate and enhance a given image.
#### The Image Processor allows a user to load in Image into the program, save it, and apply transformations such as:

1. `visualize-red` : allows the user to visualize the image as a greyscale with the red component of each pixel.
2. `visualize-blue` : allows the user to visualize the image as a greyscale with the blue component of each pixel.
3. `visualize-green` : allows the user to visualize the image as a greyscale with the green component of each pixel.
4. `visualize-value` : allows the user to visualize the image as a greyscale with the value component of each pixel.
5. `visualize-intensity`: allows the user to visualize the image as a greyscale with the intensity component of each pixel.
6. `visualize-luma` : allows the user to visualize the image as a greyscale with the luma component of each pixel.
7. `vertical-flip` : allows the user to flip the image along the vertical axis.
8. `horizontal-flip` : allows the user to flip the image along the horizontal axis.
9. `brighten` : allows the user to brighten image's RGB values by either adding a given amount.
10. `darken` : allows the user to darken the image's RGB values by either subtracting a given amount.

#### These transformations can be found when the user types "menu".

## Controller ---------------------------------------------------------------------------------------------
### Interfaces: 
`ImageProcessorController`
`ImageProcessorCmd`
`ImageFileHandler`
#### Classes:
`ImagePPMHandler`
`ImageProcessorControllerImpl`
##### Commands:
`LoadCmd`
`MenuCmd`
`SaveCmd`
`BrightnessCmd`
`HorizontalFlipCmd`
`VerticalFlipCmd`
`VisualizeCmd`

## Model --------------------------------------------------------------------------------------------------

### Interfaces:
`Image`
`ImageTransformation`
`StoredImages`
#### Classes:
`ImageImpl`
`StoredImagesImpl`
##### Transformations:
`Brightness`
`HorizontalFlip`
`VerticalFlip`
`Visualize`

## View ---------------------------------------------------------------------------------------------------

### Interfaces:
`ImageProcessorView`
#### Classes:
`ImageProcessorViewImpl`



