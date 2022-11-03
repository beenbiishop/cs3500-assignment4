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
  private final String fileName;
  private final int amount;

  public BrightnessCmd(ImageProcessorView view, StoredImages store, String fileName, int amount) {
    if (view == null || store == null || fileName == null) {
      throw new IllegalArgumentException("View, store, and file name cannot be null");
    }
    this.view = view;
    this.store = store;
    this.fileName = fileName;
    this.amount = amount;
  }


  @Override
  public void execute() {
    try {
      Image retrieved = this.store.retrieve(this.fileName);
      ImageTransformation brightness = new Brightness(this.amount);
      Image processed = brightness.transform(retrieved);
      this.store.add(this.fileName, processed, true);
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}
