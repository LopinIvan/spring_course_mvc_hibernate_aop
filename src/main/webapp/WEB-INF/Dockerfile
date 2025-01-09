# Используем официальный образ Tomcat
FROM tomcat:10.1.30

# Устанавливаем рабочую директорию
WORKDIR /usr/local/tomcat/webapps/

# Копируем ваш .war файл в папку webapps Tomcat
COPY spring_course_mvc_hibernate_aop.war ./spring_course_mvc_hibernate_aop.war

# Tomcat по умолчанию запускается на порту 8080
EXPOSE 8080

# Указываем команду для запуска Tomcat
CMD ["catalina.sh", "run"]