package jp.co.gateway.yokota.form;

import org.springframework.stereotype.Service;

/** this class has following role.
     <ul>
         <li>Convert to YGatewayRequestModel</li>
         <li>Call Client</li>
         <li>Convert response to YGatewayResponseModel</li>
         <li>Judge result</li>
     </ul>
 */

@Service
public class PaymentService {
	public YGatewayResponseModel process(String amount) {
    	// prepare req 
		YGatewayRequestModel reqModel = new YGatewayRequestModel();
    	reqModel.setAmount(amount);
    	YGatewayResponseModel resModel = null;
		try {
			resModel = YgatewayClient.executePost(reqModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resModel;
    }
}