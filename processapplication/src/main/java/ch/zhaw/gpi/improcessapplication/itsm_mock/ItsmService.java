package ch.zhaw.gpi.improcessapplication.itsm_mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItsmService {
    
    @Autowired
    private RfcRepository rfcRepository;

    public Long postRfc(Rfc rfc) {
        rfc = rfcRepository.save(rfc);

        return rfc.getrId();
    }
}
