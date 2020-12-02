package com.okexchain.msg;

import com.okexchain.env.EnvInstance;
import com.okexchain.msg.common.Message;
import com.okexchain.msg.types.MsgDepositValue;
import com.okexchain.msg.common.DecCoin;
import com.okexchain.utils.Utils;

public class MsgDeposit extends MsgBase {
    public MsgDeposit() {
        setMsgType("okexchain/staking/MsgDeposit");
    }

    public static void main(String[] args) {
        EnvInstance.setEnv("okq");

        MsgDeposit msg = new MsgDeposit();
        msg.initMnemonic(EnvInstance.getEnv().GetNode0Mnmonic());

        Message messages = msg.produceMsg("okt", "10.00000000", "okexchain10q0rk5qnyag7wfvvt7rtphlw589m7frsku8qc9");

        msg.submit(messages, "6.00000000", "200000", "");
    }

    public Message produceMsg(String denom, String amountDenom, String delegrator) {

        DecCoin d = new DecCoin();
        d.setDenom(denom);
        d.setAmount(amountDenom);

        MsgDepositValue value = new MsgDepositValue();

        System.out.println("this.operAddress:");
        System.out.println(this.operAddress);

        value.setAmount(d);
        value.setDelegatorAddress(delegrator);

        System.out.println("println this.operAdddress");

        Message<MsgDepositValue> msg = new Message<>();
        msg.setType(msgType);
        msg.setValue(value);
        return msg;
    }

}
