package controller.commands;

import controller.ImageProcessorCommand;
import model.StoredImages;

public class Brightness implements ImageProcessorCommand {

  int value;

  public Brightness(int value) {
    this.value = value;
  }

  @Override
  public void execute(StoredImages storedImages) {
    new model.transformations.Brightness()
  }

}
