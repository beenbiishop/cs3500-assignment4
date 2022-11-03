package controller.commands;

import controller.ImageProcessorCmd;
import model.Image;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.HorizontalFlip;
import view.ImageProcessorView;

public class HorizontalFlipCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final String fileName;

  public HorizontalFlipCmd(ImageProcessorView view, StoredImages store, String fileName) {
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
      ImageTransformation flip = new HorizontalFlip();
      Image processed = flip.transform(retrieved);
      this.store.add(this.fileName, processed, true);
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}
