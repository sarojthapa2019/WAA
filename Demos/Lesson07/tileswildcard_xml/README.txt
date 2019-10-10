<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>3.0.7</version>
		</dependency>
		
Only this dependency needs for use tiles + wildcard, prefix


<bean id="tilesConfigurer" 
    class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/views/**/tiles.xml</value>
			</list>
		</property>
		<property name="completeAutoload" value="true" />
	</bean>
	
Must add this line: <property name="completeAutoload" value="true" />

Enabling CompleteAutoloadTilesContainerFactory
As a prerequisite for using prefixes, you need to have CompleteAutoloadTilesContainerFactory enabled.

If you haven't enabled it yet, here is a quick checklist for you to use.

The library tiles-extras is required.
If you are using Spring, you should add the 'completeAutoload' attribute to your TilesConfigurer bean.