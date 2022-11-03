package controller;

import controller.commands.BrightnessCmd;
import controller.commands.HorizontalFlipCmd;
import controller.commands.LoadCmd;
import controller.commands.SaveCmd;
import controller.commands.VerticalFlipCmd;
import controller.commands.VisualizeCmd;
import java.awt.Image;
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
  }

  /**
   * Creates a map of all the known commands.
   *
   * @return a map of all the names of the commands and a lambda function that represents a command.
   */
  private Map<String, Function<Scanner, ImageProcessorCmd>> knownCommands() {
    Map<String, Function<Scanner, ImageProcessorCmd>> knownCommands = new HashMap<>();
    Scanner scan = new Scanner(this.input);

    knownCommands.put("load", s -> new LoadCmd());
    knownCommands.put("save", s -> new SaveCmd());
    knownCommands.put("brighten", s -> new BrightnessCmd(scan.nextInt()));
    knownCommands.put("darken", s -> new BrightnessCmd(scan.nextInt() * -1));
    knownCommands.put("horizontal-flip", s -> new HorizontalFlipCmd());
    knownCommands.put("vertical-flip", s -> new VerticalFlipCmd());
    knownCommands.put("red-component", s -> new VisualizeCmd(this.view, this.store, Channel.Red));
    knownCommands.put("blue-component", s -> new VisualizeCmd(Channel.Blue));
    knownCommands.put("green-component", s -> new VisualizeCmd(Channel.Green));

    return this.transformations = new HashMap<>(knownCommands);
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
      Function<Scanner, ImageProcessorCmd> cmd = this.knownCommands().getOrDefault(in, null);
      if (cmd == null) {
        throw new IllegalArgumentException();
      } else {
        c = cmd.apply(scan);
        c.execute(this.image);
      }
    }
  }
}

