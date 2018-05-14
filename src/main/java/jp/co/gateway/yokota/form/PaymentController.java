package jp.co.gateway.yokota.form;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PaymentController {

	@Autowired
	public PaymentService paymentService; 
	
	@GetMapping("/index")
	public String paymentSet(Model model) {
		model.addAttribute("paymentForm", new PaymentForm());
		return "index";
	}

	@PostMapping("/result")
	public String paymentPost(Model model,@ModelAttribute("paymentForm") PaymentForm paymentForm, BindingResult bindingResult,
			HttpServletRequest request) {
/*		// validate req
		if (bindingResult.hasErrors()) {
			//redirect
			return "index";
		}
*/
		// send api
		YGatewayResponseModel response = paymentService.process(paymentForm.getAmount());

		// judge result
		System.out.println(response.getMessage());
		model.addAttribute("result_code", response.getResponse_code());
		model.addAttribute("msg", response.getMessage());
		model.addAttribute("paymentForm", paymentForm);
		return "result";
	}
}