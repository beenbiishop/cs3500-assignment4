package controller.commands;

import controller.ImageProcessorCmd;
import model.Image;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.Brightness;
import view.ImageProcessorView;

public class BrightnessCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final int amount;
  private final String fileName;
  private final String newFileName;

  public BrightnessCmd(ImageProcessorView view, StoredImages store, String fileName, int amount) {
    if (view == null || store == null || fileName == null) {
      throw new IllegalArgumentException("View, store, and file name cannot be null");
    }
    if (amount == 0) {
      throw new IllegalArgumentException("Amount cannot be 0");
    }
    this.view = view;
    this.store = store;
    this.amount = amount;
    this.fileName = fileName;
    this.newFileName = newFileName;
  }


  @Override
  public void execute() {
    try {
      Image retrieved = this.store.retrieve(this.fileName);
      ImageTransformation brightness = new Brightness(this.amount);
      Image processed = brightness.transform(retrieved);
      this.store.add(this.newFileName, processed, true);
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}
