# Launch your first Java Microservice applications in Azure Container Apps with Java components

## Overview
This is the companion repository for the [Azure Container Apps Java Microservice quickstart](https://learn.microsoft.com/azure/container-apps/java-microservice-get-started). This repository contains Java samples that demonstrate how to build your own images and deploy to Azure Container Apps.

## Build your own images and deploy to Azure Container Apps

In [Azure Container Apps Java Microservice quickstart](https://learn.microsoft.com/azure/container-apps/java-microservice-get-started), you're using our [built images](https://github.com/orgs/Azure-Samples/packages?tab=packages&q=spring-petclinic) for the [Spring Petclinic microservice apps](https://github.com/spring-petclinic/spring-petclinic-microservices). If you want to customize the sample code and use your own images, you can follow the steps.

1. Fork your own copy of [Azure-samples/azure-container-apps-java-samples](https://github.com/Azure-Samples/azure-container-apps-java-samples) by clicking the Fork button in the upper right corner of the repository.

2. Fork your own copy of [spring-petclinic/spring-petclinic-microservices](https://github.com/spring-petclinic/spring-petclinic-microservices) by clicking the Fork button in the upper right corner of the repository. And clone the repository to your local machine.

3. Modify the code in your forked repository and push to your forked repository.

4. Go to your forked `azure-container-apps-java-samples` repository, navigate to the `GitHub Actions` tab, choose `Publish Petclinic images` workflow, and click `Run workflow`, then fill in the repository url of Spring Pet clinic microservices with your forked Petclinic repository url. The image tag version is optional for your customized images, you can leave it empty to use the default value `latest`.

![](resources/build-your-own-images.png)

5. After the workflow finished, go to the `Code` tab of your `azure-container-apps-java-samples` repository, click the `Packages` button at the right bottom corner to see the built images.

![](resources/github-package-button.png)

6. There should be four packages in the list, one for each of the Java microservice apps. Click on the package name to see the details of the package. Update or create your container apps with these images as how [Azure Container Apps Java Microservice quickstart](https://learn.microsoft.com/azure/container-apps/java-microservice-get-started) does.  
