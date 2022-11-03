package controller.commands;

import controller.ImageProcessorCmd;
import model.Image;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.VerticalFlip;
import view.ImageProcessorView;

public class VerticalFlipCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final String fileName;

  public VerticalFlipCmd(ImageProcessorView view, StoredImages store, String fileName) {
    if (view == null || store == null || fileName == null) {
      throw new IllegalArgumentException("View, store, and file name cannot be null");
    }
    this.view = view;
    this.store = store;
    this.fileName = fileName;
  }


  @Override
  public void execute() {
    try {
      Image retrieved = this.store.retrieve(this.fileName);
      ImageTransformation flip = new VerticalFlip();
      Image processed = flip.transform(retrieved);
      this.store.add(this.fileName, processed, true);
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}
