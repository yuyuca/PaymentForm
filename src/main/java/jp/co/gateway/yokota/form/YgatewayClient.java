package jp.co.gateway.yokota.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class YgatewayClient {
	public static YGatewayResponseModel executePost(YGatewayRequestModel requestModel) throws Exception {
		String url = "http://localhost:7777/payment_api/training/apply";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		
		EntityBuilder builder = EntityBuilder.create();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("amount", String.valueOf(requestModel.getAmount())));
		builder.setParameters(params);
		post.setEntity(builder.build());

		CloseableHttpResponse res = client.execute(post);
		String a = EntityUtils.toString(res.getEntity(), "UTF-8" );
		System.out.println(a);
		return new Gson().fromJson(a, YGatewayResponseModel.class);
	}
}