package dl.alliswell.javase.base.snmp;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;

/**
 * @author: dlliu
 * @date_time: 2021/4/19 16:18
 * @description:
 */
public class SnmpMain {

    public static void main(String[] args) throws IOException {

        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID("1.3.6.1.2.1.1.5.0")));
        pdu.setType(PDU.GET);

        Address address = GenericAddress.parse("udp:10.182.140.18/161");
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(address);
        target.setVersion(SnmpConstants.version2c);

        Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
        snmp.listen();
        ResponseEvent responseEvent = snmp.send(pdu, target);
        if (responseEvent.getResponse() == null) {
            System.out.println("time out");
        } else {
            System.out.println("Received response from: " + responseEvent.getPeerAddress());
            System.out.println(responseEvent.getResponse().toString());
        }

    }
}
