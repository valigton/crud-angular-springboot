const proxy = [
    {
      context: '/api',
      target: 'http://localhost:8080/empresas',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;