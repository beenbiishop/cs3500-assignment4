package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import model.ImageTransformation;
import model.StoredImages;
import model.StoredImagesImpl;
import model.transformations.HorizontalFlip;
import model.transformations.VerticalFlip;
import view.ImageProcessorView;

public class ImageProcessorImpl implements ImageProcessor {

  private final Readable input;
  private final ImageProcessorView view;
  private final StoredImages store;
  private final Map<String, Function<String, ImageTransformation>> transformations;

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

    //Creating a map of known transformations (command design pattern)
    Map<String, Function<Scanner, ImageTransformation>> knownCommands = new HashMap<>();

    knownCommands.put("load", s -> new HorizontalFlip(this.image));
    knownCommands.put("save", s -> new VerticalFlip(this.image));
    //edit these two so that you have a class for save and load!
    knownCommands.put("brighten", s -> new Brighten(this.image,
        s.nextInt())); // not sure how to give brighten the posInt/ not sure if this is right???
    knownCommands.put("darken", s -> new Darken(this.image, s.nextInt()));
    knownCommands.put("horizontal-flip", s -> new HorizontalFlip(this.image));
    knownCommands.put("vertical-flip", s -> new VerticalFlip(this.image));
    knownCommands.put("red-component", s -> new VisualizeR(this.image));
    knownCommands.put("blue-component", s -> new VisualizeB(this.image));
    knownCommands.put("green-component", s -> new VisualizeG(this.image));

    while (scan.hasNext()) {
      ImageTransformation c;
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

