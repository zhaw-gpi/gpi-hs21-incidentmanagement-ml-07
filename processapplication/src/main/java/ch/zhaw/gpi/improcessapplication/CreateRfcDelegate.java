package ch.zhaw.gpi.improcessapplication;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import ch.zhaw.gpi.improcessapplication.itsm_mock.Rfc;
import ch.zhaw.gpi.improcessapplication.itsm_mock.RfcRepository;

@Named("createRfcAdapter")
public class CreateRfcDelegate implements JavaDelegate {

    @Autowired
    private RfcRepository rfcRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String rfcTitle = (String) execution.getVariable("rfc_title");
        String rfcDescription = (String) execution.getVariable("rfc_description");
        String rfcReasons = (String) execution.getVariable("rfc_reasons");
        
        Rfc rfc = new Rfc();

        rfc.setrTitle(rfcTitle);
        rfc.setrDescription(rfcDescription);
        rfc.setrReasons(rfcReasons);

        rfc = rfcRepository.save(rfc);

        Long rfcId = rfc.getrId();

        execution.setVariable("rfc_id", rfcId);
    }
    
}
