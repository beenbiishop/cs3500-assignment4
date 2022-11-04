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

## Controller

***

### Interfaces:

* `ImageProcessorController` : Represents a controller for the image processor. As the user inputs
  commands, the controller validates the parameters and executes them. The controller also handles
  the exceptions thrown by the model and view, and displays them as messages to the user via the
  view.
* `ImageProcessorCmd` : Represents a supported command that the image processor can handle. The
  command is executed by calling the `execute` method, and implemented subclasses of this interface
  will handle the execution of the command
* `ImageFileHandler` :  Represents a model used to convert image files into `Image` objects.

#### Classes:

1. `ImagePPMHandler` : Implements the `ImageFileHandler` interface for converting PPM image files
   into `Image` objects, and vice versa.

2. `ImageProcessorControllerImpl`: Implements the `ImageProcessorController` interface supporting
   the
   above transformation commands as well as `load`, `menu`, and `save`.

##### Commands:

Executes the given command and store the Image in the StoredImages.

* `LoadCmd` : Implements the `ImageProcessorCmd` and represents the `load` command offered by the
  processor.
* `MenuCmd` : Implements the `ImageProcessorCmd` and represents the `menu` command offered by
  the
  processor.
* `SaveCmd` : Implements the `ImageProcessorCmd` and represents the `save` command offered by
  the
  processor.
* `BrightnessCmd` : Implements the `ImageProcessorCmd` and represents the `brighten` and `darken`
  command offered by the processor.
* `HorizontalFlipCmd` : Implements the `ImageProcessorCmd` and represents the `horizontal-flip`
  command offered by the processor.
* `VerticalFlipCmd` : Implements the `ImageProcessorCmd` and represents the `vertical-flip` command
  offered by the processor.
* `VisualizeCmd` : Implements the `ImageProcessorCmd` and represents the `visualize-<componenet>`
  command offered by the processor.

## Model

***

### Interfaces:

* `Image` : Represents an image and it's pixels.
* `ImageTransformation` : Represents a macro that can be applied to an `Image` to transform its
  pixels in some way.
* `StoredImages` : Represents a collection of  `Image`s that have been loaded into the program by
  the user, identified by the image's file name selected by the user.

#### Classes:

* `ImageImpl` : Implements the `Image` interface, each image is represented by a 2D array of
  colors.
* `StoredImagesImpl` : Implements the `StoredImages` interface. The stored images are represented
  by a Map<String, Image>, the string representing a fileName.

##### Transformations:

* `Brightness` : Implements the `ImageTransformation` interface and represents a macro that adjusts
  the brightness of an image, both up the scale and down.
* `HorizontalFlip` : Implements the `ImageTransformation` interface and represents a macro that
  flips
  an image along the horizontal axis.
* `VerticalFlip`: Implements the `ImageTransformation` interface and represents a macro that flips
  an
  image along the vertical axis.
* `Visualize` : Implements the `ImageTransformation` interface and represents a macro that
  transforms the images to visualize the greyscale image by one of the following color
  components : `visualize-red`, `visualize-blue`, `visualize-green`, `visualize-value`,
  `visualize-intensity`, `visualize-luma`.

## View

***

### Interfaces:

* `ImageProcessorView` : This interface represents the view of the Image Processor. It contains
  methods that the controller can call to render the view.

#### Classes:

* `ImageProcessorViewImpl` : Implements the ImageProcessorView interface and it's methods. Handles
  appending all the messages from the controller to the user.

## Other

***

* `ImageProcessorRunner` :  Runs the image processor in the terminal for the user.






