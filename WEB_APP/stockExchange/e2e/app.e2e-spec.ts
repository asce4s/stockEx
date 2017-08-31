import { StockExchangePage } from './app.po';

describe('stock-exchange App', () => {
  let page: StockExchangePage;

  beforeEach(() => {
    page = new StockExchangePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
