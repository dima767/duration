duration - a command-line Groovy script to calculate a duration between two dates
=================================================================================

duration.groovy is a simple command-line script to calculate and display a duration between two given dates using Joda time library

# Dependencies

First make sure that the latest Groovy is installed on your system.

Then the easiest way to have Joda time library available on the classpath for this script is to download the latest Joda time jar and place it to   

	~/.groovy/lib

# Install

Rename 
		
	duration.groovy 

to 
	
	duration 
		
and set the executable bit

Then place

	duration 

to 

	/usr/sbin
	
(make sure /usr/sbin is in your system's $PATH)	

# Run

From command line:

	duration [start date: MMM-dd-yyy] [end date: MMM-dd-yyyy or 'today']
	
	e.g. $> duration NOV-02-2008 NOV-08-2012
	or 	 $> duration JUL-21-2009 today