spring:
  quartz:
    properties:
      org:
        quartz:
          scheduler:
            instanceName: N${subAppId}
            instanceId: AUTO
            batchTriggerAcquisitionMaxCount: 5
            skipUpdateCheck: true
          jobStore:
            class: org.quartz.impl.jdbcjobstore.JobStoreTX
            driverDelegateClass: org.quartz.impl.jdbcjobstore.StdJDBCDelegate
            tablePrefix: ${quartzTablePrefix}
            isClustered: true
            clusterCheckinInterval: 15000
            useProperties: false
            dataSource: myDS
            acquireTriggersWithinLock: true
          dataSource:
            myDS:
              driver: ${driverType}
              URL: ${dbUrl}
              user: ${dbUsername}
              password: ${dbPassword}
              maxConnections: ${maxConnection}
              provider: hikaricp
          threadPool:
            class: org.quartz.simpl.SimpleThreadPool
            threadCount: ${threadCount}
            threadPriority: 5
            threadsInheritContextClassLoaderOfInitializingThread: true
    job-store-type: jdbc
    auto-startup: false
    wait-for-jobs-to-complete-on-shutdown: true
    overwrite-existing-jobs: true
    jdbc:
      initialize-schema: never