package controller;

import controller.commands.BrightnessCmd;
import controller.commands.HorizontalFlipCmd;
import controller.commands.LoadCmd;
import controller.commands.SaveCmd;
import controller.commands.VerticalFlipCmd;
import controller.commands.VisualizeCmd;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import model.StoredImages;
import model.transformations.Visualize.Channel;
import view.ImageProcessorView;

public class BenController {

  private final ImageProcessorView view;
  private final StoredImages store;
  private final Scanner scan;
  private final Map<String, Function<Scanner, ImageProcessorCmd>> commands;

  /**
   * Constructs a new ben controller object.
   *
   * @param input the input to read from
   * @param view  the view to display to
   * @param store the store to store images in
   * @throws IllegalArgumentException if any of the parameters are null
   */
  public BenController(Readable input, ImageProcessorView view, StoredImages store)
      throws IllegalArgumentException {
    if (input == null || view == null || store == null) {
      throw new IllegalArgumentException("Input, view, and store cannot be null");
    }
    this.view = view;
    this.store = store;
    this.scan = new Scanner(input);
    this.commands = new HashMap<>();
  }

  /**
   * Runs the ben controller.
   */
  public void run() {

    while (scan.hasNext()) {
      String command = scan.next();
      if (command.equalsIgnoreCase("q") || command.equalsIgnoreCase("quit")) {
        return;
      } else {
        switch (command) {
        }
      }
    }

  }

  /**
   * Adds the commands to this object's map of known commands.
   */
  private void addCommands() {
    this.commands.put("load",
        (Scanner s) -> new LoadCmd(this.view, this.store, s.next(), s.next()));
    this.commands.put("save",
        (Scanner s) -> new SaveCmd(this.view, this.store, s.next(), s.next()));
    this.commands.put("visualize-red",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Red));
    this.commands.put("visualize-green",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Green));
    this.commands.put("visualize-blue",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Blue));
    this.commands.put("visualize-value",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Value));
    this.commands.put("visualize-intensity",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Intensity));
    this.commands.put("visualize-luma",
        (Scanner s) -> new VisualizeCmd(this.view, this.store, s.next(), Channel.Luma));
    this.commands.put("brighten",
        (Scanner s) -> new BrightnessCmd(this.view, this.store, s.next(), s.nextInt()));
    this.commands.put("darken",
        (Scanner s) -> new BrightnessCmd(this.view, this.store, s.next(), s.nextInt()));
    this.commands.put("horizontal-flip",
        (Scanner s) -> new HorizontalFlipCmd(this.view, this.store, s.next()));
    this.commands.put("vertical-flip",
        (Scanner s) -> new VerticalFlipCmd(this.view, this.store, s.next()));
  }
}
