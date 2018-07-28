package br.edu.ifpb.uploadservice.consumer;

public class CommandConsumerParameters {
  private String commandChannel = "uploadServiceCommandChannel";

  public String getCommandChannel() {
    return commandChannel;
  }

  public void setCommandChannel(String commandChannel) {
    this.commandChannel = commandChannel;
  }
}
