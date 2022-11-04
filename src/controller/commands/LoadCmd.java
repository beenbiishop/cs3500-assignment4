package controller.commands;


import controller.ImageFileHandler;
import controller.ImagePPMHandler;
import controller.ImageProcessorCmd;
import java.awt.Color;
import model.Image;
import model.StoredImages;
import view.ImageProcessorView;

/**
 * Class that represents a command, "Load", that the processor can handle. Implements the
 * {@code ImageProcessorCmd} interface and execute the command. Loads an image from the Stored
 * Images.
 */
public class LoadCmd implements ImageProcessorCmd {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final String path;
  private final String fileName;

  /**
   * Constructs a Load command.
   *
   * @param view     the view to display the messages to.
   * @param store    the store to retrieve images from.
   * @param path     the file path of the image to be loaded.
   * @param fileName the file name of the image to be added.
   */
  public LoadCmd(ImageProcessorView view, StoredImages store, String path, String fileName) {
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
        ImageFileHandler handler = new ImagePPMHandler();
        Image processed = handler.process(this.path);
        this.store.add(this.fileName, processed, true);
        this.view.renderMessage(
            "Image loaded successfully as " + this.fileName + System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        sb.append(processed.getHeight()).append("x");
        sb.append(processed.getWidth()).append(System.lineSeparator());
        Color[][] pixelsTest = processed.getPixels();
        for (int i = 0; i < pixelsTest.length; i++) {
          for (int j = 0; j < pixelsTest[0].length; j++) {
            sb.append(pixelsTest[i][j].getRed()).append(" ");
            sb.append(pixelsTest[i][j].getGreen()).append(" ");
            sb.append(pixelsTest[i][j].getBlue()).append(" ");
            sb.append(System.lineSeparator());
          }
        }
        this.view.renderMessage(sb.toString());
      } else {
        this.view.renderMessage("File type not supported" + System.lineSeparator());
      }
    } catch (IllegalArgumentException e) {
      this.view.renderMessage(e.getMessage() + System.lineSeparator());
    }
  }
}
