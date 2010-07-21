#!/usr/bin/env groovy

import org.joda.time.*

if(args.size() < 2) {
    usage();
}

dateFormat = new java.text.SimpleDateFormat("MMM-d-yyyy")

try {
	startDate = args[0] == 'today' ? new Date() : dateFormat.parse(args[0])
	endDate = args[1] == 'today' ? new Date() : dateFormat.parse(args[1])
	from = new LocalDate(startDate)
	to = new LocalDate(endDate)
}
catch(Exception e) {
	usage()
}

if(from.isAfter(to)) {
	invalidDateOrder()
}

Period period = new Period(from, to)
d = period.days
w = period.weeks
m = period.months
y = period.years

output = 'The duration is [ '
if(y > 0) output += "$y " + "year" + (y > 1 ? "s " : " ")
if(m > 0) output += "$m " + "month" + (m > 1 ? "s " : " ")
if(w > 0) output += "$w " + "week" + (w > 1 ? "s " : " ")
if(d > 0) output += "$d " + "day" + (d > 1 ? "s " : " ")
if(output == 'The duration is [ ') {
    output += 'less than a day '
}
output += ']'

println output

def usage() {
	println("usage: please provide semantically valid start date and end date in the format: [MMM-d-yyyy] or 'today' string\n")
    System.exit(1)
}

def invalidDateOrder() {
	println("duration: the start date must be earlier that end date")
    System.exit(1)
}
    

