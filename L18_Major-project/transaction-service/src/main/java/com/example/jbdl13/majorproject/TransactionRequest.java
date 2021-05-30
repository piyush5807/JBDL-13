package com.example.jbdl13.majorproject;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private String fromUserId;
    private String toUserId;
    private int amount;
    private String purpose;

  public boolean isValidRequest() {
    return this.fromUserId != null
        && !this.fromUserId.equals("")
        && this.toUserId != null
        && !this.toUserId.equals("")
        && this.amount > 0;
  }
}
