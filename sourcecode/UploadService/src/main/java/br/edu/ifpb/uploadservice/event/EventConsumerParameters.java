package br.edu.ifpb.uploadservice.event;

public class EventConsumerParameters {
    private String aggregateType = "Conteudo";
    private String dispatcherId = "eventDispatcherId-1";

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public String getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(String dispatcherId) {
        this.dispatcherId = dispatcherId;
    }
}
