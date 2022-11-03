package controller.commands;

import controller.ImageProcessorCmd;
import model.Image;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.Visualize;
import model.transformations.Visualize.Channel;
import view.ImageProcessorView;

public class VisualizeCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final String fileName;
  private final Channel channel;

  public VisualizeCmd(ImageProcessorView view, StoredImages store, String fileName,
      Channel channel) {
    if (view == null || store == null || fileName == null || channel == null) {
      throw new IllegalArgumentException("View, store, file name, and channel cannot be null");
    }
    this.view = view;
    this.store = store;
    this.fileName = fileName;
    this.channel = channel;
  }


  @Override
  public void execute() {
    try {
      Image retrieved = this.store.retrieve(this.fileName);
      ImageTransformation visualize = new Visualize(this.channel);
      Image processed = visualize.transform(retrieved);
      this.store.add(this.fileName, processed, true);
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage());
    }
  }
}
