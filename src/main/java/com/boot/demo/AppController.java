package com.boot.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	
	@RequestMapping("/products")
	public String getProducts(Model model)
	{
		model.addAttribute("title", "PLP");
		
		
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:8016/authservice/oauth/token");
		resourceDetails.setScope(Arrays.asList("read_products"));
		resourceDetails.setClientId("webshop");
		resourceDetails.setClientSecret("webshopsecret");
		resourceDetails.setUsername("qa_user1");
		resourceDetails.setPassword("12345678");
		
		
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		
		String accessToken = restTemplate.getAccessToken().toString();
		
		System.out.println("TOKEN >> "+accessToken);
		
		ResponseEntity<ArrayList<ProductData>> resp = restTemplate.exchange("http://localhost:8014/microserviceX/getProducts", HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<ProductData>>(){});
		
		System.out.println("Resp data >> "+resp.getBody().size());
		
		model.addAttribute("products", resp.getBody());
		
		return "productListPage";
	}
	
}
