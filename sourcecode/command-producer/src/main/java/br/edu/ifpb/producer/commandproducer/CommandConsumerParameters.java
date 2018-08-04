package br.edu.ifpb.producer.commandproducer;

public class CommandConsumerParameters {
  private String commandChannel = "uploadServiceCommandChannel";
  private String replyChannel = "uploadServiceReplyChannel";
  private String dispatcherId = "uploadDispatcher1";
  private String aggregateType = "Conteudo";
  private String subscriberId = "commandproducer";

  public String getAggregateType() {
    return aggregateType;
  }

  public void setAggregateType(String aggregateType) {
    this.aggregateType = aggregateType;
  }

  public String getSubscriberId() {
    return subscriberId;
  }

  public void setSubscriberId(String subscriberId) {
    this.subscriberId = subscriberId;
  }

}
