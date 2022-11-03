package controller.commands;

import controller.ImageFileHandler;
import controller.ImagePPMHandler;
import controller.ImageProcessorCmd;
import model.Image;
import model.StoredImages;
import view.ImageProcessorView;

public class SaveCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final String path;
  private final String fileName;

  public SaveCmd(ImageProcessorView view, StoredImages store, String path, String fileName) {
    if (view == null || store == null || path == null || fileName == null) {
      throw new IllegalArgumentException("View, store, path, and fileName cannot be null");
    }
    this.view = view;
    this.store = store;
    this.path = path;
    this.fileName = fileName;
  }


  @Override
  public void execute() {
    try {
      if (this.path.endsWith(".ppm")) {
        ImageFileHandler handler;
        Image retrieved = this.store.retrieve(this.fileName);
        handler = new ImagePPMHandler();
        handler.export(retrieved, this.path);
      } else {
        this.view.renderMessage("File type not supported");
      }
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}