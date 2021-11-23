let should = chai.should();

describe('Lecture', () => { // Top level grouping of tests - probably for a specific JS file (containing many functions)

  describe('Hello There', () => { // sub grouping - probably for a specific method

    // This is a test case
    it("should take 'Hello' and 'There' and return 'ellohere'", () => {
      nonStart('Hello', 'There').should.equal('ellohere');
    });

    // This is another test case
    it("should take 'Java' and 'Code' and return 'avaode'", () => {
      nonStart('Java', 'Code').should.equal('avaode');
    });
  });
});
