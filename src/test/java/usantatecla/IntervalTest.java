package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithIntersectedIntervalOpenOpenThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(0);
    Point rightIntervalIntersected = new Point(6.6);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithIncludedIntervalOpenOpenThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(0);
    Point rightIntervalIntersected = new Point(2.2);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithIntersectedIntervalOpenOpenFromBelowThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-4.4);
    Point rightIntervalIntersected = new Point(0);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithNotIntersectedIntervalOpenOpenFromBelowThenFalse() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(-4.4);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithNotIntersectedIntervalOpenOpenFromAboveThenFalse() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(6.6);
    Point rightIntervalIntersected = new Point(10);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithIntersectedIntervalClosedClosedFromBelowThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(-2.2);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getGreater()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithNotIntersectedIntervalClosedClosedFromBelowThenFalse() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(-2.2);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithIntersectedIntervalClosedClosedFromAboveThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(4.4);
    Point rightIntervalIntersected = new Point(8);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getLess()).closed(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithNotIntersectedIntervalClosedClosedFromAboveThenFalse() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(4.4);
    Point rightIntervalIntersected = new Point(8);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenlWhenIntersectWithSameIntervalOpenOpenThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-2.2);
    Point rightIntervalIntersected = new Point(4.4);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaClosedClosedlWhenIntersectWithSameIntervalClosedClosedThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-2.2);
    Point rightIntervalIntersected = new Point(4.4);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaClosedClosedlWhenIntersectWithIntersectedIntervalClosedClosedFromBelowThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(-2.2);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaClosedClosedlWhenIntersectWithNotIntersectedIntervalClosedClosedFromBelowThenFalse() {
    Interval interval = this.intervalBuilder.closed(left.getGreater()).closed(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(-2.2);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaClosedClosedlWhenIntersectWithIntersectedIntervalClosedClosedFromAboveThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(4.4);
    Point rightIntervalIntersected = new Point(8);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaClosedClosedlWhenIntersectWithNotIntersectedIntervalClosedClosedFromAboveThenFalse() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getLess()).build();
    Point leftIntervalIntersected = new Point(4.4);
    Point rightIntervalIntersected = new Point(8);
    Interval intervalIntersected = new IntervalBuilder().closed(leftIntervalIntersected.getEquals()).closed(rightIntervalIntersected.getEquals()).build();
    assertFalse(interval.intersect(intervalIntersected));
  }
  @Test
  public void givenIntervaOpenOpenWhenIntersectWithLargerIntervalOpenOpenThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftIntervalIntersected = new Point(-6.6);
    Point rightIntervalIntersected = new Point(4.4);
    Interval intervalIntersected = new IntervalBuilder().open(leftIntervalIntersected.getEquals()).open(rightIntervalIntersected.getEquals()).build();
    assertTrue(interval.intersect(intervalIntersected));
  }
}