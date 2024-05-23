(function() {
    const loadAssets = () => {
        LazyLoad.js(['//lcap-official-bucket.codewave.163.com/packages/vue@2/dist/vue.min.js','//lcap-official-bucket.codewave.163.com/packages/@lcap/mobile-ui@0.16.6/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/@lcap/mobile-template@0.11.5/cloudAdminDesigner.umd.min.js','//lcap-official-bucket.codewave.163.com/packages/lcap-h5-login@0.2.1/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/cw_echarts_library@0.1.0/dist-theme/index.js','//lcap-official-bucket.codewave.163.com/packages/make_img_and_qr_code@1.1.2/dist-theme/index.js','/m/bundle.28aaca44.min.js']);
        LazyLoad.css(['//lcap-official-bucket.codewave.163.com/packages/@lcap/mobile-ui@0.16.6/dist-theme/index.css','//lcap-official-bucket.codewave.163.com/packages/@lcap/mobile-template@0.11.5/cloudAdminDesigner.css']);
    }

    loadAssets();
})()
