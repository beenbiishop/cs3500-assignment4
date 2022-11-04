package controller.commands;

import controller.ImageProcessorCmd;
import model.Image;
import model.ImageTransformation;
import model.StoredImages;
import model.transformations.Visualize;
import model.transformations.Visualize.Channel;
import view.ImageProcessorView;


/**
 * Class that represents a command, "Visualize", that the processor can handle. Implements the
 * {@code ImageProcessorCmd} interface and execute the command. Visualizes the image according to
 * the given channel (R, G, B, Luma, Value, Intensity).
 */
public class VisualizeCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final Channel channel;
  private final String fileName;
  private final String newFileName;

  /**
   * Constructs a Visual command.
   *
   * @param view        the view to display the messages to.
   * @param store       the store to store images in.
   * @param channel     the enum that represents which visualize transformation to perform.
   * @param fileName    the file name of the image to be transformed.
   * @param newFileName the file name of the new transformed image.
   */
  public VisualizeCmd(ImageProcessorView view, StoredImages store, Channel channel, String fileName,
      String newFileName) {
    if (view == null || store == null || fileName == null || channel == null) {
      throw new IllegalArgumentException("View, store, file name, and channel cannot be null");
    }
    this.view = view;
    this.store = store;
    this.channel = channel;
    this.fileName = fileName;
    this.newFileName = newFileName;
  }


  @Override
  public void execute() {
    Image retrieved = this.store.retrieve(this.fileName);
    ImageTransformation visualize = new Visualize(this.channel);
    Image processed = visualize.transform(retrieved);
    this.store.add(this.newFileName, processed, true);
    this.view.renderMessage(
        "Image " + this.fileName + " has been visualized successfully by the channel "
            + this.channel.toString() + System.lineSeparator());
  }
}
