let should = chai.should();

describe('Lecture', () =>
{
  describe('removeFirstLetter tests', () =>
  {
    it("should accept input 'Hello', 'There' and return 'ellohere'", () =>
    {
      // arrange
      const expected = 'ellohere';

      // act
      const  actual = removeFirstLetter('Hello', 'There');

      // assert
      actual.should
            .equal(expected);
    });
    it("should accept input 'C', 'Sharp' and return 'harp'", () =>
    {
      // arrange
      const expected = 'harp';

      // act
      const  actual = removeFirstLetter('C', 'Sharp');

      // assert
      actual.should
            .equal(expected);
    });
  });
});
