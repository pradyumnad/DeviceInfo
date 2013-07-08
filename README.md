DeviceInfo
==========

Helper Class that enables easy access of important info of device.


USAGE
-------

import the DeviceInfo class.

Directly access the members

    Log.i("DeviceInfo", "Model : "+DeviceInfo.model);
  
For some of the function you need to provide the applicationContext

    Log.i("DeviceInfo", "Resolution : "+DeviceInfo.resolution(getApplicationContext()));
  
CONTACT
-------
Follow [@pradyumna_d](http://twitter.com/pradyumna_d) on Twitter for the latest news.

LICENSE
------------
DeviceInfo is available under the CC BY 3.0 license.
