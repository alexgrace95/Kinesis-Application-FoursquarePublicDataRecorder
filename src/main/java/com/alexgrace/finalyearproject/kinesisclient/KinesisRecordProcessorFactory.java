/*
 * Copyright 2013-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Further developed & adapted by Alex Grace for research purposes only. (ag00248@surrey.ac.uk)
 *
 * Licensed under the Amazon Software License (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/asl/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.alexgrace.finalyearproject.kinesisclient;

import com.alexgrace.finalyearproject.kinesisclient.OtherEntities.FoursquareClient;
import com.alexgrace.finalyearproject.kinesisclient.OtherEntities.LocationFilter;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory;

import java.util.List;

/**
* Used to create new record processors.
*/
public class KinesisRecordProcessorFactory implements IRecordProcessorFactory {

	private String dbHost;
	private int dbPort;
    private String dbUser;
    private String dbPass;
    private List<FoursquareClient> foursquareClient;
    private int fsqVersion;
    private List<LocationFilter> locationFilter;



    /**
    * Constructor.
    */
   public KinesisRecordProcessorFactory(String dbHost, int dbPort, String dbUser, String dbPass, List<FoursquareClient> foursquareClient, int fsqVersion, List<LocationFilter> locationFilter) {
       super();

       this.dbHost = dbHost;
       this.dbPort = dbPort;
       this.dbUser = dbUser;
       this.dbPass = dbPass;
       this.foursquareClient = foursquareClient;
       this.fsqVersion = fsqVersion;
       this.locationFilter = locationFilter;

   }

   /**
    * {@inheritDoc}
    */
   public IRecordProcessor createProcessor() {
       return new KinesisRecordProcessor(dbHost, dbPort, dbUser, dbPass, foursquareClient, fsqVersion, locationFilter);
   }

}
