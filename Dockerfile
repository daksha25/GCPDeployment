FROM sath89/oracle-xe-11g
ADD devops.dmp /home/oracle/
EXPOSE 1521
EXPOSE 8080
