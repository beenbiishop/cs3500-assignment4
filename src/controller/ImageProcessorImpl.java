package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import model.Image;
import model.ImageTransformation;
import model.transformations.Brighten;
import model.transformations.Darken;
import model.transformations.HorizontalFlip;
import model.transformations.VerticalFlip;
import model.transformations.VisualizeB;
import model.transformations.VisualizeG;
import model.transformations.VisualizeR;
import view.ImageView;

public class ImageProcessorImpl implements ImageProcessor {

  private final Image image;
  private final ImageView view;
  private final Readable input;

  /**
   * The constructor for the MarbleSolitaireControllerImpl.
   *
   * @param input (Readable value).
   * @param model (MarbleSolitaireModel model).
   * @param view  (MarbleSolitaireView view).
   * @throws IllegalArgumentException if any of the given params are null.
   */
  public ImageProcessorImpl(Image model, ImageView view, Readable input) {
    this.image = model;
    this.view = view;
    this.input = input;

    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Given object is null.");
    }
  }

  public void go() {
    Scanner scan = new Scanner(this.input);

    //Creating a map of known transformations (command design pattern)
    Map<String, Function<Scanner, ImageTransformation>> knownCommands = new HashMap<>();

    knownCommands.put("load", s -> new HorizontalFlip(this.image));
    knownCommands.put("save", s -> new VerticalFlip(this.image));
    //edit these two so that you have a class for save and load!
    knownCommands.put("brighten", s -> new Brighten(this.image, s.nextInt())); // not sure how to give brighten the posInt/ not sure if this is right???
    knownCommands.put("darken", s -> new Darken(this.image, s.nextInt()));
    knownCommands.put("horizontal-flip", s -> new HorizontalFlip(this.image));
    knownCommands.put("vertical-flip", s -> new VerticalFlip(this.image));
    knownCommands.put("red-component", s -> new VisualizeR(this.image));
    knownCommands.put("blue-component", s -> new VisualizeB(this.image));
    knownCommands.put("green-component", s -> new VisualizeG(this.image));

    while (scan.hasNext()) {
      ImageTransformation c;
      String in = scan.next();
      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit"))
        return;
      Function<Scanner, ImageTransformation> cmd =
              knownCommands.getOrDefault(in, null);
      if (cmd == null) {
        throw new IllegalArgumentException();
      } else {
        c = cmd.apply(scan);
        c.apply(this.image);
      }
    }
  }
}

