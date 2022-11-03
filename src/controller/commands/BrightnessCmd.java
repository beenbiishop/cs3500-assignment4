package controller.commands;

import controller.ImageProcessorCommand;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.Brightness;

public class BrightnessCmd implements ImageProcessorCommand {

  int value;

  public BrightnessCmd(int value) {
    this.value = value;
  }

  @Override
  public void execute(StoredImages storedImages) {
    ImageTransformation brightness = new Brightness(this.value);
    brightness.transform(storedImages.retrieve()); // give the transform method an image
  }

}
