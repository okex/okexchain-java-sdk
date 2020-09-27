package io.cosmos.msg;

import io.cosmos.common.EnvInstance;
import io.cosmos.msg.utils.Message;
import io.cosmos.msg.utils.type.MsgListValue;
import io.cosmos.msg.utils.type.MsgSendValue;
import io.cosmos.types.Token;

import java.util.ArrayList;
import java.util.List;

public class MsgList extends MsgBase {

    public MsgList() {
        setMsgType("okexchain/dex/MsgList");
    }

    public static void main(String[] args) {
        MsgList msg = new MsgList();

        msg.initMnemonic("puzzle glide follow cruel say burst deliver wild tragic galaxy lumber offer");

        Message messages = msg.produceListMsg(
                "eos-f4d",
                "okt",
                "1.00000000");

        // okexchaincli tx dex list --from captain --base-asset eos-a99 --quote-asset okt -y -b block --fees 0.01okt
        msg.submit(messages, "0.01000000", "200000", "okexchain dex list!");
    }

    public Message produceListMsg(String listAsset, String quoteAsset, String initPrice) {

        MsgListValue value = new MsgListValue();
        value.setOwner(this.address);
        value.setListAsset(listAsset);
        value.setQuoteAsset(quoteAsset);
        value.setInitPrice(initPrice);

        Message<MsgListValue> msg = new Message<>();
        msg.setType(msgType);
        msg.setValue(value);
        return msg;
    }
}