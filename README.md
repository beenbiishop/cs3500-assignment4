# CS3500 Assignment 4 - Image Processor

_Smita Rosemary and Ben Bishop_

## Overview

***

This project represents an Image Processor that allows you to manipulate and enhance a given image.

The Image Processor allows a user to load in Image into the program, save it, and apply
transformations such as:

* `visualize-red` : allows the user to visualize the image as a greyscale with the red component of
  each pixel.
* `visualize-blue` : allows the user to visualize the image as a greyscale with the blue component
  of each pixel.
* `visualize-green` : allows the user to visualize the image as a greyscale with the green
  component of each pixel.
* `visualize-value` : allows the user to visualize the image as a greyscale with the value
  component of each pixel.
* `visualize-intensity`: allows the user to visualize the image as a greyscale with the intensity
  component of each pixel.
* `visualize-luma` : allows the user to visualize the image as a greyscale with the luma component
  of each pixel.
* `vertical-flip` : allows the user to flip the image along the vertical axis.
* `horizontal-flip` : allows the user to flip the image along the horizontal axis.
* `brighten` : allows the user to brighten image's RGB values by either adding a given amount.
* `darken` : allows the user to darken the image's RGB values by either subtracting a given
  amount.

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

## Model

***

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

## View

***

### Interfaces:
`ImageProcessorView`
#### Classes:
`ImageProcessorViewImpl`



