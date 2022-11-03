package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import model.ImageTransformation;
import model.StoredImages;
import model.StoredImagesImpl;
import model.transformations.Visualize;
import model.transformations.Visualize.Channel;
import view.ImageProcessorView;

// TODO: Add two maps of commands, one for image processing commands and one for menu, etc

/**
 * Implements the {@link ImageProcessor} interface to provide a controller for the image processor.
 */
public class ImageProcessorImpl implements ImageProcessor {

  private final Readable input;
  private final ImageProcessorView view;
  private final StoredImages store;
  private final Map<String, Function<String, ImageTransformation>> menu;
  private Map<String, Function<Scanner, ImageProcessorCmd>> transformations;


  /**
   * Constructs a new image processor controller with the given input and view.
   *
   * @param input the input to read from
   * @param view  the view to display to
   */
  public ImageProcessorImpl(Readable input, ImageProcessorView view) {
    if (input == null || view == null) {
      throw new IllegalArgumentException("Input and view cannot be null");
    }
    this.input = input;
    this.view = view;
    this.store = new StoredImagesImpl();
    this.transformations = new HashMap<>();
    // TODO: Add transformations
  }

  /**
   * Runs the image processor.
   */
  public void run() {
    Scanner scan = new Scanner(this.input);
    while (scan.hasNext()) {
      ImageProcessorCmd c;
      // Render the menu
      // menu
      String in = scan.next();
      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      }
      Function<Scanner, ImageTransformation> cmd = knownCommands.getOrDefault(in, null);
      if (cmd == null) {
        throw new IllegalArgumentException();
      } else {
        c = cmd.apply(scan);
        c.apply(this.image);
      }
    }
  }
}

