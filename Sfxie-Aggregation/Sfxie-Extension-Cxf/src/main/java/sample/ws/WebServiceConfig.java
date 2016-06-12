/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package sample.ws;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import sample.ws.service.Hello;
import sample.ws.service.HelloPortImpl;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	/**
	 * {@inheritDoc}
	 * <p>This implementation is empty.
	 */
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(new EndpointInterceptor(){

			@Override
			public boolean handleRequest(MessageContext messageContext,
					Object endpoint) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean handleResponse(MessageContext messageContext,
					Object endpoint) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean handleFault(MessageContext messageContext,
					Object endpoint) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void afterCompletion(MessageContext messageContext,
					Object endpoint, Exception ex) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        return new ServletRegistrationBean(cxfServlet, "/Service/*");
    }

    @Bean(name = "cxf")
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Hello myService() {
        return new HelloPortImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), myService());
        endpoint.publish("/Hello");
        return endpoint;
    }
}
