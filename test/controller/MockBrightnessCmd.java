package controller;

import java.util.Objects;

import model.StoredImages;
import view.ImageProcessorView;

public class MockBrightnessCmd implements ImageProcessorCmd {
  final StringBuilder log;
  private final ImageProcessorView view;
  private final StoredImages store;
  private final int amount;
  private final String fileName;
  private final String newFileName;

  public MockBrightnessCmd(ImageProcessorView view, StoredImages store, int amount, String fileName,
                           String newFileName, StringBuilder log) {
    if (view == null || store == null || fileName == null || newFileName == null) {
      throw new IllegalArgumentException("View, store, and file names cannot be null");
    }
    if (amount == 0) {
      throw new IllegalArgumentException("Amount cannot be 0");
    }
    this.view = view;
    this.store = store;
    this.amount = amount;
    this.fileName = fileName;
    this.newFileName = newFileName;
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Executes this object's command.
   */
  @Override
  public void execute() {
    log.append(String.format("Increase brightness by: ", this.amount));
    log.append(String.format("File Name: ", this.fileName));
    log.append(String.format("New File Name: ", this.fileName));
  }
}
