(function() {
    const loadAssets = () => {
        LazyLoad.js(['//lcap-official-bucket.codewave.163.com/packages/vue@2/dist/vue.min.js','//lcap-official-bucket.codewave.163.com/packages/cloud-ui.vusion@0.18.7/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-pc-template@0.8.5/cloudAdminDesigner.umd.min.js','//lcap-official-bucket.codewave.163.com/packages/lcap-printPage@0.1.1/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-video-flv@0.1.8/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-amap-poi@0.1.3/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-you-data@0.1.8/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-wang-editor@0.1.5/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-clock@0.1.0/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/u-sider-modal@0.2.7/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-echarts-line@2.2.0/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-echarts-bar@2.2.0/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-echarts-basic@0.1.2/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-signature@0.1.2/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-amap-nav@0.1.5/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/lcap-login@1.2.2/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/cw_echarts_library@0.1.0/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/make_img_and_qr_code@1.1.2/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/print_block_sdk@0.1.0/dist-theme/index.js','/bundle.675066c1.min.js']);
        LazyLoad.css(['//lcap-official-bucket.codewave.163.com/packages/cloud-ui.vusion@0.18.7/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/lcap-pc-template@0.8.5/cloudAdminDesigner.css','//lcap-official-bucket.codewave.163.com/packages/lcap-printPage@0.1.1/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/lcap-video-flv@0.1.8/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/lcap-you-data@0.1.8/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/lcap-echarts-basic@0.1.2/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/lcap-signature@0.1.2/dist-theme/index.css']);
    }

    
    if(window.ICESTARK && window.ICESTARK.root) {
        Object.assign(window.ICESTARK, {
            appEnter({ container, customProps  }) {
                window.LcapMicro = window.LcapMicro || {};
                Object.assign(window.LcapMicro, {});
            
                if(window.LcapMicro.noAuthUrl && !window.LcapMicro.noAuthFn)
                    window.LcapMicro.noAuthFn = () => {
                        location.href = window.LcapMicro.noAuthUrl;
                    };
            
                if(window.LcapMicro.loginUrl && !window.LcapMicro.loginFn)
                    window.LcapMicro.loginFn = () => {
                        location.href = window.LcapMicro.loginUrl;
                    };

                if(window.LcapMicro.notFoundUrl && !window.LcapMicro.notFoundFn)
                    window.LcapMicro.notFoundFn = () => {
                        location.href = window.LcapMicro.notFoundUrl;
                    };
                
                // 兼容 ICESTARK 旧集成方式
                if(!window.LcapMicro.loginFn)
                    window.LcapMicro.loginFn = window.ICESTARK.loginFn;
                if(!window.LcapMicro.routePrefix)
                    window.LcapMicro.routePrefix = window.ICESTARK.basename;
                if(!window.LcapMicro.proxyPrefix)
                    window.LcapMicro.proxyPrefix = window.ICESTARK.proxyPrefix;

                window.LcapMicro.container = container; 
                window.LcapMicro.props = customProps;
                loadAssets();
            },
            appLeave({ container }) {
                container.innerHTML = null;
                if (window.appVM) {
                    window.appVM.$destroy();
                }
                document.querySelectorAll('script.lazyload').forEach((ele) => {
                    ele.active = false;
                });
            },
        });
    } else
        loadAssets();

})()
