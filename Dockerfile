FROM openjdk17-tomcat10
WORKDIR
/opt/tomcat/bin
COPY "movie-video-stream" "app"
CMD["java","-jar","movie-video-stream"]
CMD["RUN","catalina.sh"]



