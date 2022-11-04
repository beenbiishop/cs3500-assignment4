package controller;

/**
 * Represents a supported command that the image processor can handle. The command is executed by
 * calling the {@code execute} method, and implemented subclasses of this interface will handle the
 * execution of the command.
 */
public interface ImageProcessorCmd {

  /**
   * Executes this object's command.
   */
  void execute();

}
